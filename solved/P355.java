public class Twitter {
    private int index;
    private HashMap<Integer, ArrayList<Integer>> twitter;
//    private HashMap<Integer, Integer> reverseTwitter;
    private ArrayList<Integer> postList;
    private HashMap<Integer, Set<Integer>> followship;
    
    /** Initialize your data structure here. */
    public Twitter() {
        this.index = 0;
        this.twitter = new HashMap<Integer, ArrayList<Integer>>();
//      this.reverseTwitter = new HashMap<Integer, Integer>();
        this.postList = new ArrayList<Integer>();
        this.followship = new HashMap<Integer, Set<Integer>>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        if (this.twitter.containsKey(userId)){
            tmp = twitter.get(userId);
        }
        tmp.add(this.index);
        postList.add(this.index, tweetId);
        this.twitter.put(userId, tmp);
//      this.reverseTwitter.put(this.index, userId);
        this.index ++;      
    }
    
    private List<Integer> merging(List<Integer>r1, List<Integer>r2, int len){
        List<Integer> r = new ArrayList<Integer>();
        if (r1.size() == 0 || r1.get(0) <= r2.get(0)){
            for (int x = r2.size() - 1; x >= 0; x --){
                r.add(r2.get(x));
                if (r.size() >= len) break;
            }
            int x = 0;
            while(x < r1.size() && r.size() < len) r.add(r1.get(x++));
            return r;
        }
        else{
            if (r1.size() >= len && r1.get(r1.size()-1) >= r2.get(r2.size()-1)) return r1;
            int x = 0;
            int y = r2.size() - 1;
            int z = 0;
            for (; x < r1.size() && y >= 0 && z < len; z ++){
                if (r1.get(x) > r2.get(y)) r.add(r1.get(x++));
                else r.add(r2.get(y--));
            }
            if (z < len){
                while (r.size() < len && x < r1.size()) r.add(r1.get(x++));
                while (r.size() < len && y >= 0) r.add(r2.get(y--));
            }
            return r;
        }
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        int cnt = 10;
        List<Integer> result = new ArrayList<Integer>();
        Set<Integer> followers = followship.containsKey(userId)? followship.get(userId):new HashSet<Integer>();
        followers.add(userId);
        for (Integer follower: followers){
            if (this.twitter.containsKey(follower)){
                ArrayList<Integer> tmp = this.twitter.get(follower);
                result = merging(result, tmp, cnt);             
            }
        }
        for (int i = 0; i < result.size(); i ++) result.set(i, this.postList.get(result.get(i)));
        return result;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        Set<Integer> tmp = new HashSet<Integer>();
        if (this.followship.containsKey(followerId)){
            tmp = this.followship.get(followerId);
        }
        tmp.add(followeeId);
        this.followship.put(followerId, tmp);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (this.followship.containsKey(followerId)){
            Set<Integer> tmp = followship.get(followerId);
            if (tmp.contains(followeeId)) tmp.remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */