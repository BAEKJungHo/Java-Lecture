package test;

class Member implements Comparable<Member> {
    private String id;
    private String name;

    public Member(String id, String name){
      this.id = id;
      this.name = name;
    }

    public String getIdentify() {
      return id + ", " + name;
    }

    @Override
    public int compareTo(Member o){
      if(this.id.compareTo(o.id) > 0) return 1;
      else if(this.id.equals(o.id)) return 0;
      else return -1;
    }
  }