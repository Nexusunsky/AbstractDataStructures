package practice;

/**
 * 5，安装空调的一次投标包括公司名，设备描述，设计性能，设备价格，及安装费用。
 * 设计表示任意投标的一个ADT，然后设计另外一个ADT，表示投标集合。
 * 第二个ADT应该包含根据价格和性能查找投标的方法。还要注意，一个公司能投多个标，每个有不同的设备。
 * 说明每个ADT操作，说明方法的目的，描述它的参数，写方法头的伪代码。然后写一个用于投标方法的Java接口，javadoc风格的注释。
 *
 * @author: haoliu on 06/08/2018 23:01
 */
public class ProjectFive {
    interface TenderSet {
        /**
         * 根据 投标的价格和性能来查询投标
         *
         * @param price       Price of tender
         * @param performance performance of tender
         * @return Tender return the result of find tender from TenderSet.
         */
        Tender find(String price, String performance);
    }

    class Tender {
        private String companyName;
        private String deviceDescribe;
        private String performance;
        private String price;
        private String cost;

        public String getCompanyName() {
            return companyName;
        }

        public String getDeviceDescribe() {
            return deviceDescribe;
        }

        public String getPerformance() {
            return performance;
        }

        public String getPrice() {
            return price;
        }

        public String getCost() {
            return cost;
        }
    }
}
