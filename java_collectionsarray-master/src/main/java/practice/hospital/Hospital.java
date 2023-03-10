package practice.hospital;


public class Hospital {
    public static float[] generatePatientsTemperatures(int patientsCount) {
        float[] patientTemperature = new float[patientsCount];
        for (int i = 0; i < patientTemperature.length; i++) {
            patientTemperature[i] = Math.round(((float) (Math.random() * 8) + 32) * 10) / 10.0f;
        }
        return patientTemperature;
    }

    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
            Округлите среднюю температуру с помощью Math.round до 2 знаков после запятой,
            а температуры каждого пациента до 1 знака после запятой
        */
        String patientTemperature = "";
        int healthyPatient = 0;
        float averageTemperature = 0.00F;
        for (int i = 0; i < temperatureData.length; i++) {
            averageTemperature += temperatureData[i];
            patientTemperature += temperatureData[i] + " ";
            if (temperatureData[i] >= 36.2f && temperatureData[i] <= 36.9f) {
                healthyPatient++;
            }
        }
        averageTemperature = Math.round((averageTemperature / temperatureData.length) * 100) / 100.00f;

        String report =
                "Температуры пациентов: " + patientTemperature.trim() + System.lineSeparator() +
                        "Средняя температура: " + averageTemperature + System.lineSeparator() +
                        "Количество здоровых: " + healthyPatient;

        return report;
    }
}

