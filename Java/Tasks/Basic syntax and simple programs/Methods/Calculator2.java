/* Please, do not rename it */
class Problem {

    public static void main(String[] args) {
        String operator = args[0];
        int answer = Integer.parseInt(args[1]);

        for (int i = 2; i < args.length; i++) {
            int tmp = Integer.parseInt(args[i]);

            if ("MIN".equals(operator)) {
                if (answer > tmp) {
                    answer = tmp;
                }

            } else if ("MAX".equals(operator)) {
                if (answer < tmp) {
                    answer = tmp;
                }

            } else {
                answer += tmp;
            }
        }

        System.out.println(answer);
    }
}
