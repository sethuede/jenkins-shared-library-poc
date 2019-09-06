def call() {
  node {
    
    
      
    def p = pipelineCfg()
         sh """
         cd /var/lib/jenkins/workspace/${JOB_NAME}/
         ls
         echo ${name}
         echo ${maha}
         """
         sh "echo ${p.branch}"
         sh "echo ${p.test}"
        
  
}
}
