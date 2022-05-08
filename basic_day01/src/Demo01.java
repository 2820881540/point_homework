public class Demo01 {
    /**
     *身高是具有遗传性的，子女的身高和父母的身高有一定的关系。假定，父母和子女的身高遗传关系如下：
     * 	儿子身高（厘米）＝(父亲身高＋母亲身高) ×1.08÷2
     * 	女儿身高（厘米）＝(父亲身高×0.923＋母亲身高) ÷2
     * 	现有父亲身高177CM,母亲身高165CM。求子女身高分别预计为多少？
     *
     *
     * 111
     *
     * */
    public static void main(String[] args) {
        double father_height = 177;
        double mother_height = 165;

        double son_height = (father_height+mother_height)*1.08/2;
        double daught_height = (father_height*0.923+mother_height)/2;

        System.out.println("儿子身高："+son_height+"\n"+"女儿身高："+daught_height);

        int x = 10;
        int y = x++ + x++ + x++;
        System.out.println("y="+y); // y的值是多少？

    }
}
