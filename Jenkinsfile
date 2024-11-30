def colorMap = [
    "SUCCESS" : "good",
    "FAILURE" : "danger"
]
pipeline {
    agent {
        docker {
            image 'node:18-alpine'
            reuseNode true
        }
    }
    stages {
        stage('Init') {
            steps {
                script {
                    buildscript = load 'scripts/build.groovy'
                    testscript = load 'scripts/test.groovy'
                    deliverscript = load 'scripts/deliver.groovy'
                }
            }

        }
        stage('Build') {
            steps {
                script{
                    buildscript.execute()
                }
            }

        }
        stage('Test') {
            steps {
                script{
                     testscript.execute()
                }
            }

        }
         stage('Deliver') {
            steps {
                script{
                    deliverscript.execute()
                }
            }
        }
    }
    post {
        always {
            echo "Build Notification"
            slackSend (
                channel: '#automation-builds',
                color: colorMap[currentBuild.currentResult],
                message: "Build ${env.BUILD_NUMBER} was *${currentBuild.currentResult}*. More info at ${env.BUILD_URL}"
            )
        }
    }
}
