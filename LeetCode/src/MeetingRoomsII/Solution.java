package MeetingRoomsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
//        Interval[] arrayIntervals = {new Interval(567707, 730827), new Interval(166232, 719216), new Interval(634677, 756013), new Interval(285191, 729059), new Interval(237939, 915914), new Interval(201296, 789707), new Interval(578258, 585240), new Interval(164298, 218749), new Interval(37396, 968315), new Interval(666722, 934674), new Interval(742749, 824917), new Interval(141115, 417022), new Interval(613457, 708897), new Interval(343495, 994363), new Interval(380250, 428265), new Interval(214441, 493643), new Interval(588487, 811879), new Interval(97538, 262361), new Interval(312269, 400232), new Interval(119183, 598077), new Interval(48359, 662082), new Interval(275411, 998607), new Interval(732520, 813383), new Interval(523587, 945442), new Interval(25499, 187818), new Interval(384094, 677532), new Interval(515481, 904358), new Interval(367073, 534689), new Interval(74379, 285755), new Interval(5175, 274185), new Interval(217306, 359251), new Interval(157681, 697795), new Interval(10408, 50527), new Interval(244728, 788413), new Interval(60159, 513570), new Interval(87670, 618955), new Interval(123002, 685804), new Interval(379941, 544148), new Interval(752885, 952000), new Interval(93326, 513158), new Interval(724941, 998846), new Interval(380834, 713191), new Interval(44977, 758923), new Interval(82478, 863827), new Interval(191702, 202103), new Interval(132379, 894865), new Interval(33622, 873933), new Interval(29205, 85762), new Interval(154893, 736522), new Interval(65801, 673648), new Interval(524615, 925054), new Interval(54903, 503215), new Interval(184486, 923679), new Interval(429446, 722503), new Interval(433374, 648218), new Interval(221866, 866873), new Interval(460293, 767671), new Interval(120556, 899800), new Interval(471650, 884153), new Interval(260903, 444940), new Interval(764956, 900171), new Interval(309912, 608549), new Interval(185563, 806731), new Interval(120163, 485407), new Interval(418426, 787505), new Interval(366182, 765471), new Interval(387482, 509524), new Interval(269290, 965760), new Interval(601620, 925056), new Interval(77986, 263210), new Interval(307558, 385490), new Interval(232270, 339488), new Interval(500796, 742417), new Interval(380705, 468257), new Interval(65075, 908144), new Interval(199833, 764292), new Interval(236020, 666098), new Interval(66185, 189939), new Interval(82749, 497671), new Interval(191217, 375842), new Interval(197768, 679395), new Interval(193098, 715861), new Interval(441216, 949168), new Interval(70640, 164591), new Interval(47205, 785067), new Interval(488750, 598205), new Interval(13213, 617815), new Interval(323318, 918171), new Interval(414290, 772744), new Interval(252493, 666573), new Interval(271755, 888520), new Interval(127330, 511709), new Interval(221211, 255366), new Interval(189693, 496201), new Interval(59348, 213072), new Interval(848245, 886578), new Interval(297360, 706720), new Interval(416648, 713923), new Interval(597845, 948100), new Interval(598216, 887392), new Interval(291671, 885441), new Interval(470685, 911757), new Interval(753936, 779842), new Interval(402359, 607590), new Interval(405439, 709142), new Interval(214403, 993931), new Interval(410523, 809693), new Interval(394872, 807901), new Interval(104075, 813021), new Interval(726, 567120), new Interval(118216, 440587), new Interval(451018, 831426), new Interval(134313, 437745), new Interval(580445, 723821), new Interval(812199, 974362), new Interval(206646, 330279), new Interval(76614, 396575), new Interval(490128, 495052), new Interval(159918, 891113), new Interval(317757, 944351), new Interval(367136, 561514), new Interval(47693, 397141), new Interval(624885, 944320), new Interval(22262, 713662), new Interval(14887, 710022), new Interval(887543, 997929), new Interval(211476, 296206), new Interval(560776, 619572), new Interval(49048, 602570), new Interval(169071, 575311), new Interval(645076, 686241), new Interval(577490, 777716), new Interval(431009, 702971), new Interval(197437, 728985), new Interval(62590, 339659), new Interval(474951, 503156), new Interval(637923, 899120), new Interval(973131, 976272), new Interval(450579, 954240), new Interval(318272, 635074), new Interval(68073, 677042), new Interval(127777, 185375), new Interval(426756, 912534), new Interval(370844, 592811), new Interval(724, 630896), new Interval(732456, 896268), new Interval(592795, 641974), new Interval(321324, 337142), new Interval(505427, 594421), new Interval(74917, 273591)};
        Interval[] arrayIntervals = {
                new Interval(0, 30),
                new Interval(5, 10),
                new Interval(15, 20),
                new Interval(30, 40)
        };
        ArrayList<Interval> intervals = new ArrayList<>(Arrays.asList(arrayIntervals));
        System.out.println(minMeetingRooms(intervals));
    }
    private static class Interval {
        public int start, end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static int minMeetingRooms(List<Interval> intervals) {
        if (intervals.size() == 0) {
            return 0;
        }
        // Разбираем все интервалы на starts и ends
        int[] starts = new int[intervals.size()];
        int[] ends = new int[intervals.size()];
        for (int i = 0; i < intervals.size(); i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }

        // Сортируем все starts и ends
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0, endsItr = 0;
        for (int start : starts) {
            // Если следующий start нельзя объединить
            // с предыдущим end - добавляем для него комнату
            if (start < ends[endsItr]) {
                rooms++;
            } else {
                // Иначе двигаем указатель end'ов
                endsItr++;
            }
        }
        return rooms;
    }
}
