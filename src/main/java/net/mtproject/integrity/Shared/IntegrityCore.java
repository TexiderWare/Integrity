package net.mtproject.integrity.Shared;

public class IntegrityCore {
    private static IntegrityCore instance;

    public IntegrityCore() {
        instance = this;
    }

    public static IntegrityCore getInstance() {
        return instance;
    }
}