class Solution {
    public int calanderDayOfYear(String day,int prefixSum[]){
        int month=Integer.parseInt(day.substring(0,2));
        int date=Integer.parseInt(day.substring(3));
        return prefixSum[month-1]+date;
    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {

        int days[]={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int prefixSum[]=new int[13];
        prefixSum[1]=31;
        for(int i=2;i<13;i++){
            prefixSum[i]=prefixSum[i-1]+days[i-1];
        }
       int AliceA=calanderDayOfYear(arriveAlice,prefixSum);
       int AliceL=calanderDayOfYear(leaveAlice,prefixSum);
       int BobA=calanderDayOfYear(arriveBob,prefixSum);
       int BobL=calanderDayOfYear(leaveBob,prefixSum);

        int overLap=Math.min(AliceL,BobL)-Math.max(AliceA,BobA)+1;
        return Math.max(0,overLap);
    }
}