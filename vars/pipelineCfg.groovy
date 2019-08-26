def call() {

  Map pipelineCfg = readYaml(file: "/var/lib/jenkins/workspace/${JOB_NAME}/pipeline.yaml")
  sh "echo ${JOB_NAME}"
  sh "pwd"
  sh "ls"
  return pipelineCfg
}
