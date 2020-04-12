package common;

public class LocaleMath {

    /**
     * Возвращает случайное число в диапозоне от <code>minValue</code> до <code>maxValue</code>
     * @param minValue нижняя граница (включительно)
     * @param maxValue верхняя граница (включительно)
     * @return рандомное число в указанном диапозоне
     */
    public static int randInt(int minValue, int maxValue){
        return (int)(Math.random()*maxValue) + minValue;
    }
}
