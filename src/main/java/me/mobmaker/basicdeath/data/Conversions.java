package me.mobmaker.basicdeath.data;

public class Conversions {

    public static double msToTime(double time, String unit) {
        return switch (unit) {
            case "second" -> round(time / 1000, 1);
            case "minute" -> round(time / 60000, 2);
            case "hour" -> round(time / 3600000, 3);
            default -> 0;
        };
    }

    public static int round(int num, int precision) {
        return Math.round(num * (10 * precision)) / (10 * precision);
    }

    public static double round(double num, int precision) {
        return (double) Math.round(num * (10 * precision)) / (10 * precision);
    }

    public static long round(long num, int precision) {
        return Math.round(num * (10L * precision)) / (10L * precision);
    }
}
