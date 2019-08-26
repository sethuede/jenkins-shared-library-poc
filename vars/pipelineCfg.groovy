def call() {
  sh "pwd"
  sh "ls"
  Map pipelineCfg = readYaml(file: "${workspace}/${JOB_NAME}/pipeline.yaml")
  return pipelineCfg
}
