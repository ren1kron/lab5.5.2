package utility;

public class ExecutionResponse {
    private boolean exitCode;
    private String massage;

    public ExecutionResponse(boolean exitCode, String massage) {
        this.exitCode = exitCode;
        this.massage = massage;
    }

    public ExecutionResponse(String massage) {
        this(true, massage);
    }

    public boolean getExitCode() {
        return exitCode;
    }
    public String getMassage() {
        return massage;
    }
    public String toString() {
        return String.valueOf(exitCode)+";"+massage;
    }
}
