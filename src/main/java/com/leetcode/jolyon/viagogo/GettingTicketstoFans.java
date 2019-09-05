package com.leetcode.jolyon.viagogo;

import java.util.*;

public class GettingTicketstoFans {
    public static class Event {
        PriorityQueue<Integer> tickets;
        int eventId;
        int x;
        int y;
        private int distance;

        public Event(int eventId, int x, int y, PriorityQueue<Integer> tickets) {
            this.eventId = eventId;
            this.tickets = tickets;
            this.x = x;
            this.y = y;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }
    }

    public static class Buyer {
        int x;
        int y;

        Buyer(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String args[]) throws Exception {

        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scan = new Scanner(System.in);

        int sizeOfWorld = Integer.parseInt(scan.nextLine());
        int numberOfEvents = Integer.parseInt(scan.nextLine());
        List<Event> eventList = new ArrayList<>();
        while (numberOfEvents > 0) {
            String eventLine = scan.nextLine();
            String[] eventInfo = eventLine.split("\\s");
            int eventId = Integer.parseInt(eventInfo[0]);
            int x = Integer.parseInt(eventInfo[1]);
            int y = Integer.parseInt(eventInfo[2]);
            PriorityQueue<Integer> tickets = new PriorityQueue<Integer>();
            for (int i = 3; i < eventInfo.length; i++) {
                tickets.add(Integer.parseInt(eventInfo[i]));
            }
            Event newEvent = new Event(eventId, x, y, tickets);
            eventList.add(newEvent);
            numberOfEvents--;
        }

        Comparator<Event> comp = (e1, e2) -> {
            if (e1.distance < e2.distance) {
                return -1;
            } else if (e1.distance > e2.distance) {
                return 1;
            } else {
                int p1 = e1.tickets.peek();
                int p2 = e2.tickets.peek();
                if (p1 > p2) {
                    return 1;
                } else if (p1 < p2) {
                    return -1;
                } else {
                    return Integer.compare(e1.eventId, e2.eventId);
                }
            }
        };

        int numberOfBuyers = Integer.parseInt(scan.nextLine());


        List<Buyer> buyers = new ArrayList<>();
        while (numberOfBuyers > 0) {
            String buyerLine = scan.nextLine();
            String[] buyerInfo = buyerLine.split("\\s");
            int x = Integer.parseInt(buyerInfo[0]);
            int y = Integer.parseInt(buyerInfo[1]);
            buyers.add(new Buyer(x, y));
            numberOfBuyers--;
        }

        for (int i = 0; i < buyers.size(); i++) {
            PriorityQueue<Event> pool = new PriorityQueue<>(comp);
            int x = buyers.get(i).x;
            int y = buyers.get(i).y;
            for (Event e : eventList) {
                if(e.tickets.isEmpty()) continue;
                e.setDistance(calculateManhattanDistance(x, y, e.x, e.y));
                pool.add(e);
            }
            if (!pool.isEmpty()) {
                Event optimalEvent = pool.poll();
                int price = optimalEvent.tickets.poll();
                System.out.println(optimalEvent.eventId + " " + price);
            } else {
                System.out.println(-1 + " " + 0);
            }
        }
    }

    // The following method get the manhatten distance betwen two points (x1,y1) and (x2,y2)
    public static int calculateManhattanDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}

