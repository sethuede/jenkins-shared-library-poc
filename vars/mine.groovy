def call() {
  node {
    def p = pipelineCfg()

     
    stage('Checkout') {
      sh "echo ${p.appname}"
      sh "echo ${p.new}"
      sh "echo ${p.check}"
      sh "ls"
      sh "echo ${p.env}"
      sh "echo $BUILD_NUMBER"
    }
    
    
         
          
        
    
  }
}
