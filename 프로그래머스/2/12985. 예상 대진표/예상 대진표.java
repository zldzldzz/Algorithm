class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        int around=-1;
        int bround=-2;
        while(around!=bround){
            around = a/2+a%2;
            bround = b/2+b%2;
            answer++;
            a=around;
            b=bround;
        }
        System.out.println(answer);
        
        return answer;
    }
}