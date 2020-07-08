package cn.zhangchg.leetcode.arrays;

public class Test {
    /**
     * 答致命三问
     * 终回归现实
     */
    public static void main(String[] args) {
        boolean a = false,
                b = false,
                c = false;
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println(decode("5oKo5aSa6auY77yIY23vvInvvJ8="));
        int height = 0;
        while (height < 140) {
            try {
                String h = scanner.nextLine();
                height = Integer.parseInt(h);
                if (height >= 140) {
                    break;
                }
            } catch (Exception e) {
                System.out.println(decode("5oKo6L6T5YWl5LqG5ZWl77yf"));
            }
            System.out.println(decode("5oKo5aSa6auY77yIY23vvInvvJ8="));
        }
        if (180 > height) {
            System.out.println(decode("5oKo6L+Y5piv566X5LqG5ZCn77yB"));
            return;
        }
        a = true;
        System.out.println(decode("5oKo5a2Y5qy+5aSa5bCR77yI5LiH77yJ5ZWK77yf"));
        String d = scanner.nextLine();
        int deposit = Integer.parseInt(d);
        if (deposit < 500) {
            System.out.println(decode("6YKj5oKo5YaN5Yqq5Yqq5Yqb5ZWK"));
            return;
        }
        b = true;
        System.out.println(decode("5oKo6KeJ5b6X6Ieq5bex5biF5ZCX77yf77yI5biF5oiW5LiN5biF77yJ"));
        String face = scanner.nextLine();
        if ("5LiN5biF".equals(encode(face))) {
            System.out.println(decode("6YKj5oKo5YaN5Yqq5Yqq5Yqb5ZWK"));
            return;
        }
        c = true;
        if (a && b && c) {
            System.out.println(decode("5ZOO5ZOf77yB5oKo57uI5LqO5Yiw6L+Z5YS/5p2l5ZWm77yB6L+Y5piv5aW95aW95pWy5Luj56CB5ZCn77yB6auY5a+M5biF5ZOq6L+Z5LmI5aSa5ZWK77yB5ZOI5ZOI77yB"));
            try {
                java.util.concurrent.TimeUnit.MILLISECONDS.sleep(1500);
            } catch (InterruptedException e) {
            }
            System.out.println(decode("6L+Y5piv56Wd5oKo6Lqr5L2T5YGl5bq344CB5bel5L2c6aG65Yip44CB5q+P5aSp5byA5b+D5ZCn77yB5ZOI5ZOI77yB"));
            try {
                java.util.concurrent.TimeUnit.MILLISECONDS.sleep(1500);
            } catch (InterruptedException e) {
            }
            System.out.println(decode("5Yqz54Om57uZ5Liq6K+E6K665ZCn772e"));
        }
    }

    private static String encode(String str) {
        return new String(java.util.Base64.getEncoder().encode(str.getBytes()));
    }

    private static String decode(String str) {
        return new String(java.util.Base64.getDecoder().decode(str));
    }
}
