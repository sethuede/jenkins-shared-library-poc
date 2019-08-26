def call() {
  node {
    def p = pipelineCfg()
         sh "cd /var/lib/jenkins/workspace/${JOB_NAME}/"
         sh "echo ${p.branch}"
         sh "echo ${p.test}"
     
    stage('Checkout') {
      sh "echo ${p.appname}"
      sh "ls"
      sh "echo ${p.env}"
      sh "echo $BUILD_NUMBER"
      sh "echo ${p.branch}"
      sh "echo ${p.test}"
      sh "echo ${p.Branch}"
      
    }
    
    
         
          
        
    
  }
}
