def call() {
  node {
    def p = pipelineCfg()

     
    stage('Checkout') {
      sh "echo ${p.appname}"
      sh "ls"
      sh "echo ${p.env}"
      sh "echo $BUILD_NUMBER"
      sh "echo ${p.branch}"
    }
    
    
         
          
        
    
  }
}
