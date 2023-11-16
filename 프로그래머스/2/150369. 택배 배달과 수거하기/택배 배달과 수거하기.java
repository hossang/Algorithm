class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        //디버깅하기 개빡세다 진짜;;
        long res = 0L;
        int nn =n-1;
        int nnn=n-1;
        
        while(true) {
            //어느 장소가 0,0이면 안가도 돼
            while(nn>=0&&nnn>=0&&deliveries[nn]==0&&pickups[nnn]==0) {
                nn--;
                nnn--;
            }
            res+=(nnn+1)*2;
            //배달
            int cc = cap;
            while(cc>0&&nn>=0) {
                if(deliveries[nn]==0) {
                    nn--;
                    continue;
                }
                if(cc -deliveries[nn] >=0) {
                    cc-=deliveries[nn];
                    deliveries[nn--] = 0;
                    continue;
                }
                if(cc -deliveries[nn] < 0) {
                    deliveries[nn] -= cc;
                    cc=0;
                    continue;
                }
                if(cc==cap) {
                    nn--;
                    break;
                }
            }
            //수거
            cc = cap;
            while(cc>0&&nnn>=0) {
                if (pickups[nnn] == 0) {
                    nnn--;
                    continue;
                }
                if(cc -pickups[nnn] >=0) {
                    cc-=pickups[nnn];
                    pickups[nnn--] = 0;
                    continue;
                }
                if(cc -pickups[nnn] < 0) {
                    pickups[nnn] -= cc;
                    cc=0;
                }
                if(cc==cap) {
                    nnn--;
                    break;
                }
            }
            int x= Math.max(nn,nnn);
            nn = x;
            nnn = x;
            if(x<=-1) {
                break;
            }
        }
        return res;
    }
}