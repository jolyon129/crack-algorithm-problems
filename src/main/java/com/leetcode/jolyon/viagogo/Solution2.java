package com.leetcode.jolyon.viagogo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

class SupplierListItemAux {
    String supplierName;
    Supplier<Integer> getTicketNumberMethod;
    Supplier<Double> getTicketPriceMethod;
    Supplier<Integer> getIdMethod;

    public SupplierListItemAux(String supplierName, Supplier<Integer> getTicketNumberMethod, Supplier<Double> getTicketPriceMethod, Supplier<Integer> getIdMethod) {
        this.supplierName = supplierName;
        this.getTicketNumberMethod = getTicketNumberMethod;
        this.getTicketPriceMethod = getTicketPriceMethod;
        this.getIdMethod = getIdMethod;
    }

    public int getTicketNumber() {
        return getTicketNumberMethod.get();
    }

    public double getTicketPrice() {
        return getTicketPriceMethod.get();
    }

    public int getId() {
        return getIdMethod.get();
    }

}

class SupplierListAux<T>{
//    private final Class<T> type;
    Supplier<List<T>> getListMethod;
    Class<T> listItem;
    public SupplierListAux(Supplier<List<T>> getListMethod, Class<T> ListItem) {
        this.getListMethod = getListMethod;
        this.listItem = ListItem;
    }

    public List<T> getList(){
        return getListMethod.get();
    }
}

class ListingApp {

    public static void main(String[] args) throws Exception {
        ViagogoApi viagogo = new ViagogoApi();
        SupplierAApi supplierA = new SupplierAApi();
        SupplierBApi supplierB = new SupplierBApi();

        List<Event> events = viagogo.getEvents();
        List<Listing> listings = new ArrayList<Listing>();
        List<SupplierListAux> supplierList = new ArrayList<>();
        supplierList.add(new SupplierListAux<SupplierAListing>(supplierA::getAvaiableListings, SupplierAListing.class));
        supplierList.add(new SupplierListAux<SupplierBListing>(supplierB::getListings, SupplierBListing.class));
        for(SupplierListAux sup:supplierList){
        }
//        for (Event event : events) {
//            int eventId = supplierA.getEventId(event.getName());
//            List<SupplierAListing> aListings = supplierA.getAvailableListings(eventId);
//            for (SupplierAListing l : aListings) {
//                listings.add(new Listing(event, l.getTicketQuantity(), l.getTicketPrice(), l.getId(), "Supplier A"));
//            }
//
//            List<SupplierBListing> bListings = supplierB.getListings(event.getName());
//            for (SupplierBListing l : bListings) {
//                double price = l.getTotalPrice() / l.getAvailableTickets();
//                listings.add(new Listing(event, l.getAvailableTickets(), price, l.getListingId(), "Supplier B"));
//            }
//        }

//        viagogo.CreateListings(listings);
    }
}

