package me.manglam.ecoplugin.data;

import me.manglam.ecoplugin.players.TopPlayer;

import java.util.*;
import java.util.stream.Collectors;

public class EconomyDAO {

    private static final Map<UUID, Double> balances = new HashMap<>();

    public static void createPlayer(UUID uuid) {
        balances.put(uuid, 0.0);
    }

    public static boolean playerExists(UUID uuid) {
        return balances.containsKey(uuid);
    }

    public static double getBalance(UUID uuid) {
        return balances.getOrDefault(uuid, 0.0);
    }

    public static void addToBalance(UUID uuid, double amount) {
        double currentBalance = getBalance(uuid);
        balances.put(uuid, currentBalance + amount);
    }

    public static List<TopPlayer> getTopPlayers(int limit) {
        return balances.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(limit)
                .map(entry -> new TopPlayer(entry.getKey().toString(), entry.getValue()))
                .collect(Collectors.toList());
    }
}

