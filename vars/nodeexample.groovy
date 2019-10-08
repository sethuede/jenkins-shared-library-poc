def call() {
  node {    
    def p = pipelineCfg()
                sh """
                cd ${JOB_NAME}
                echo 'Building..'
                docker build -t durgaprasad444/${p.appname}:v1 .
                """
            }
        }
        
   
