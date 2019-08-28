def call() {
  node {
    
    def p = pipelineCfg()
    def branch = p.branch
    def jobname = p.jobName
       checkout([$class: 'GitSCM',
                 branches: [[name: "*/${branch}"]],
        doGenerateSubmoduleConfigurations: false,
        extensions: [],
        submoduleCfg: [],
        userRemoteConfigs: [[
            
          url: "https://github.com/durgaprasad444/${jobname}.git"
             ]]])
         sh """
         git clone https://github.com/durgaprasad444/${jobname}.git
         cd /var/lib/jenkins/workspace/${JOB_NAME}/
         ls
         """
         sh "echo ${p.branch}"
         sh "echo ${p.test}"
        
  }
}
