package com.leetcode.jolyon.viagogo;

import com.leetcode.jolyon.Lising;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ViagogoListingApp {
    static class SupplierListAux {
        String SupplierName;
        //        List<T> list;
        Supplier<Integer> getTicketNumberMethod;
        Supplier<Double> getTicketPriceMethod;
        Supplier<Integer> getIdMethod;

        public SupplierListAux(String supplierName, Supplier<Integer> getTicketNumberMethod,
                               Supplier<Double> getTicketPriceMethod,
                               Supplier<Integer> getIdMethod) {
            SupplierName = supplierName;
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

        public String getSupplierName() {
            return SupplierName;
        }
    }

    public static void main(String[] args) {
        ViagogoApi viagogo = new ViagogoApi();
        SupplierAApi supplierAApi = new SupplierAApi();
        SupplierBApi supplierBApi = new SupplierBApi();
        List<SupplierListAux> supplierList = new ArrayList<>();
        List<SupplierAListing> aListings = supplierAApi.getAvaiableListings();
        for (SupplierAListing l : aListings) {
            supplierList.add(new SupplierListAux("Supplier A",
                    l::getTickectQuantity, l::getTicketPrice, l::getId));
        }
        List<Lising> lisings = new ArrayList<>();
        for(SupplierListAux supAux: supplierList){
//            lisings.add(new Lising(event, supAux.getTicketNumber()));
        }

    }
}
