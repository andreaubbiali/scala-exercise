//il codice non funziona

val configFile = new java.io.File("~/.myapprc")

// l'if fa anche da assegnamento
val configFilePath = if (configFile.exists()) {
    configFile.getAbsolutePath()
} else {
    configFile.createNewFile()
    configFile.getAbsolutePath()
}