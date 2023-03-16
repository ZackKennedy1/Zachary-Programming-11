public class OrganiseEvents {

    public ArrayList<Event> EventList2 = new ArrayList<>();
    public ArrayList<Event> EventList2Sorted = new ArrayList<>();
    public static Arraylist allEventsOrganised(){
        for (Event e : lists) {
            EventList2.add(e);}
        EventList.getItems().clear();
        //Loop organises the items in the array list into a new list, sorted by ascending order by startTime
        for (int i = 0; i < EventList2.size(); i++) {
            //Each if loop includes a size requirement to avoid an out of bounds error
            //For each item, checks if startTime is smaller or equal to the startTime at each index of the array list.

            if(EventList2.size() == 1){
                EventList2Sorted.add(0, EventList2.get(i));
                continue;
            }
            if(EventList2.size() > 0){
                if (Integer.parseInt(EventList2.get(i).getStartTime()) <= Integer.parseInt(EventList2.get(0).getStartTime())) {
                    EventList2Sorted.add(0, EventList2.get(i));
                    continue;
                }
            } if(EventList2.size() > 1){
                if (Integer.parseInt(EventList2.get(i).getStartTime()) <= Integer.parseInt(EventList2.get(1).getStartTime())) {
                    EventList2Sorted.add(1, EventList2.get(i));
                    continue;
                }
            } if(EventList2.size() > 2){
                if (Integer.parseInt(EventList2.get(i).getStartTime()) <= Integer.parseInt(EventList2.get(2).getStartTime())) {
                    EventList2Sorted.add(2, EventList2.get(i));
                    continue;
                }
            } if(EventList2.size() > 3){
                if(Integer.parseInt(EventList2.get(i).getStartTime()) <= Integer.parseInt(EventList2.get(3).getStartTime())){
                    EventList2Sorted.add(3, EventList2.get(i));
                    continue;}
            } if(EventList2.size() > 4){
                if(Integer.parseInt(EventList2.get(i).getStartTime()) <= Integer.parseInt(EventList2.get(4).getStartTime())){
                    EventList2Sorted.add(4, EventList2.get(i));
                    continue;}
            } if(EventList2.size() > 5) {
                if (Integer.parseInt(EventList2.get(i).getStartTime()) <= Integer.parseInt(EventList2.get(5).getStartTime())) {
                    EventList2Sorted.add(5, EventList2.get(i));
                }
            }
        }
    }
}
