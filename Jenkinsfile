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
    }
}
