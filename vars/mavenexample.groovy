pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh """
                cd ${JOB_NAME}
                echo 'Building..'
                docker build -t durgaprasad444/${appname}:v1 .
                """
            }
        }
        
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
