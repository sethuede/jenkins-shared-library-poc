def call() {
  node {
    def p = pipelineCfg()
       checkout([$class: 'GitSCM',
                 branches: [[name: '*/' + ${p.branch}]],
        doGenerateSubmoduleConfigurations: false,
        extensions: [],
        submoduleCfg: [],
        userRemoteConfigs: [[
            
url: 'https://github.com/durgaprasad444/${p.jobName}.git'
             ]]])
         sh """
         cd /var/lib/jenkins/workspace/${JOB_NAME}/
         ls
         """
         sh "echo ${p.branch}"
         sh "echo ${p.test}"
        
  }
}
