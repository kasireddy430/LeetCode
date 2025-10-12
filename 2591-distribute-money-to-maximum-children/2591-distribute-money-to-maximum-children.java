class Solution {
    public int distMoney(int money, int children) {
        money -= children;

        if(money < 0){
            return -1;
        }

        int div = money / 7;
        int rem = money % 7;

        if(div == children && rem == 0){
            return div;
        }

        if(div == children - 1 && rem == 3){
            return div - 1;
        }

        return Math.min(div, children - 1);
    }
}