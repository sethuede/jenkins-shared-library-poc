def call() {
  node {
    
    def p = pipelineCfg()
    def branch = p.branch
    def jobname = p.jobName
    
       checkout([$class: 'GitSCM',
                 branches: [[name: "*/${p.branch}"]],
        doGenerateSubmoduleConfigurations: false,
        extensions: [],
        submoduleCfg: [],
        userRemoteConfigs: [[
            
          url: "https://github.com/durgaprasad444/${p.jobName}.git"
             ]]])
         sh """
         
         ls
         echo $(basename $(dirname $JOB_NAME))
         """
         sh "echo ${p.branch}"
         sh "echo ${p.test}"
        
  }
}
