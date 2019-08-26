def call() {
  sh "pwd"
  sh "ls"
  Map pipelineCfg = readYaml(file: "${workspace}/pipeline.yaml")
  return pipelineCfg
}
