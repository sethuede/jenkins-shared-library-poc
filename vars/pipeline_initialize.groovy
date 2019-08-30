def call() {
  node {
     stage('Checkout') {
       jsl = library(
  identifier: "jenkins-shared-library@master",
  retriever: modernSCM(
    [
      $class: 'GitSCMSource',
      remote: 'https://github.com/durgaprasad444/jenkins-shared-library-poc.git'
    ]
  )
)
       
      sh "cd /var/lib/jenkins/workspace/${JOB_NAME}/"
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
