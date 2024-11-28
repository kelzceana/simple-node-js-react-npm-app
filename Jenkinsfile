pipeline {
    agent {
        docker {
            image 'node:18-alpine'
            reuseNode true
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'npm install'
            }

        }
        stage('Test') {
            steps {
                sh './jenkins/scripts/test.sh'
            }

        }
    }
}
