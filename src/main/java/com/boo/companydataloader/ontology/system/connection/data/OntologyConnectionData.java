package com.boo.companydataloader.ontology.system.connection.data;
import java.io.File;

public class OntologyConnectionData implements IConnectionData {
    private String ontologyPath;

    private File ontologyFile;

    private String ontologyName;

    public OntologyConnectionData(File ontologyFile, String ontologyName) {
        this.ontologyFile = ontologyFile;
        String modifiedFilePath = ontologyFile.getAbsolutePath()
                .replace("\\", "/")
                .replace("\\", "/");
        this.ontologyName = "file://" + modifiedFilePath + "/" + ontologyName + "#";
        this.ontologyPath = "file://" + modifiedFilePath + "/" + ontologyName + "/";
    }

    public String getOntologyPath() {
        return ontologyPath;
    }

    public void setOntologyPath(String ontologyPath) {
        this.ontologyPath = ontologyPath;
    }

    public File getOntologyFile() {
        return ontologyFile;
    }

    public void setOntologyFile(File ontologyFile) {
        this.ontologyFile = ontologyFile;
    }

    public String getOntologyModelName() {
        return ontologyName;
    }

    public void setOntologyModelName(String ontologyModelName) {
        this.ontologyName = ontologyModelName;
    }

    @Override
    public String toString() {
        return "OntologyConnectionData{" +
                "ontologyPath='" + ontologyPath + '\'' +
                ", ontologyFile=" + ontologyFile +
                ", ontologyModelName='" + ontologyName + '\'' +
                '}';
    }
}
