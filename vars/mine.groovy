def call() {
  node {
    
    def p = pipelineCfg()
    def branch = p.branch
    def jobname = p.jobName
    def test = JOB_NAME
    def (name, value) = test.split("/")
       checkout([$class: 'GitSCM',
                 branches: [[name: "*/${p.branch}"]],
        doGenerateSubmoduleConfigurations: false,
        extensions: [],
        submoduleCfg: [],
        userRemoteConfigs: [[
            
          url: "https://github.com/durgaprasad444/${p.jobName}.git"
             ]]])
         sh """
         cd /var/lib/jenkins/workspace/${JOB_NAME}/
         ls
         echo ${name}
         """
         sh "echo ${p.branch}"
         sh "echo ${p.test}"
        
  }
}
