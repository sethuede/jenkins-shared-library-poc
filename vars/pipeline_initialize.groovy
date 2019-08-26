def call() {
  node {
     stage('Checkout') {
      sh "/var/lib/jenkins/workspace/${JOB_NAME}/"
    }
  

    def p = pipelineCfg()

   switch(p.pipelineType) {
      case 'python':
        // Instantiate and execute a Python pipeline
            mine()
   }
   switch(p.pipelineType) {
      case 'maven':
        // Instantiate and execute a Python pipeline
            test()
    
   }
   }
}
