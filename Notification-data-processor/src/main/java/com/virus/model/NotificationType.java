package com.virus.model;

public enum NotificationType {
    M("Mail"), S("SMS");

    public final String label;

    private NotificationType(String label) {
        this.label = label;
    }
}
