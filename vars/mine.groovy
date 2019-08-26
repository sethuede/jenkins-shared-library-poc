def call() {
  node {
    def p = pipelineCfg()
         sh """
         cd cd /var/lib/jenkins/workspace/${JOB_NAME}/
         ls
         """
         sh "echo ${p.branch}"
         sh "echo ${p.test}"
        
  }
}
