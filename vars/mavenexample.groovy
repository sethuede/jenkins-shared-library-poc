def call() {
  node {    
    def p = pipelineCfg()
                sh """
                cd /var/lib/jenkins/workspace/${JOB_NAME}/
                echo 'Building..'
                mvn clean install
                docker build -t durgaprasad444/${p.appname}:v1 .
                """
            }
        }
