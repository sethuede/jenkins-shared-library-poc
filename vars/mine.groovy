def call() {
  node {
    def branch = p.branch
    def jobname = p.jobName
    def p = pipelineCfg()
       checkout([$class: 'GitSCM',
                 branches: [[name: '*/${branch}']],
        doGenerateSubmoduleConfigurations: false,
        extensions: [],
        submoduleCfg: [],
        userRemoteConfigs: [[
            
url: 'https://github.com/durgaprasad444/${jobname}.git'
             ]]])
         sh """
         cd /var/lib/jenkins/workspace/${JOB_NAME}/
         ls
         """
         sh "echo ${p.branch}"
         sh "echo ${p.test}"
        
  }
}
