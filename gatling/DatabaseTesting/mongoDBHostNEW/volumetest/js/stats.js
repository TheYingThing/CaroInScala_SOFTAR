var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "3000",
        "ok": "1165",
        "ko": "1835"
    },
    "minResponseTime": {
        "total": "118",
        "ok": "118",
        "ko": "10088"
    },
    "maxResponseTime": {
        "total": "60014",
        "ok": "44177",
        "ko": "60014"
    },
    "meanResponseTime": {
        "total": "22587",
        "ok": "12983",
        "ko": "28684"
    },
    "standardDeviation": {
        "total": "21379",
        "ok": "11545",
        "ko": "23809"
    },
    "percentiles1": {
        "total": "10642",
        "ok": "9876",
        "ko": "10659"
    },
    "percentiles2": {
        "total": "35014",
        "ok": "20046",
        "ko": "60000"
    },
    "percentiles3": {
        "total": "60001",
        "ok": "36047",
        "ko": "60002"
    },
    "percentiles4": {
        "total": "60009",
        "ok": "43812",
        "ko": "60011"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 90,
    "percentage": 3
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 59,
    "percentage": 2
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 1016,
    "percentage": 34
},
    "group4": {
    "name": "failed",
    "count": 1835,
    "percentage": 61
},
    "meanNumberOfRequestsPerSecond": {
        "total": "35.714",
        "ok": "13.869",
        "ko": "21.845"
    }
},
contents: {
"req_load-ec4d1": {
        type: "REQUEST",
        name: "load",
path: "load",
pathFormatted: "req_load-ec4d1",
stats: {
    "name": "load",
    "numberOfRequests": {
        "total": "1500",
        "ok": "204",
        "ko": "1296"
    },
    "minResponseTime": {
        "total": "1382",
        "ok": "1382",
        "ko": "10088"
    },
    "maxResponseTime": {
        "total": "60003",
        "ok": "22465",
        "ko": "60003"
    },
    "meanResponseTime": {
        "total": "15544",
        "ok": "10122",
        "ko": "16398"
    },
    "standardDeviation": {
        "total": "15153",
        "ok": "5047",
        "ko": "16012"
    },
    "percentiles1": {
        "total": "10541",
        "ok": "9218",
        "ko": "10544"
    },
    "percentiles2": {
        "total": "10734",
        "ok": "13565",
        "ko": "10711"
    },
    "percentiles3": {
        "total": "60000",
        "ok": "19819",
        "ko": "60000"
    },
    "percentiles4": {
        "total": "60000",
        "ok": "22115",
        "ko": "60001"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 204,
    "percentage": 14
},
    "group4": {
    "name": "failed",
    "count": 1296,
    "percentage": 86
},
    "meanNumberOfRequestsPerSecond": {
        "total": "17.857",
        "ok": "2.429",
        "ko": "15.429"
    }
}
    },"req_save-43781": {
        type: "REQUEST",
        name: "save",
path: "save",
pathFormatted: "req_save-43781",
stats: {
    "name": "save",
    "numberOfRequests": {
        "total": "1500",
        "ok": "961",
        "ko": "539"
    },
    "minResponseTime": {
        "total": "118",
        "ok": "118",
        "ko": "14425"
    },
    "maxResponseTime": {
        "total": "60014",
        "ok": "44177",
        "ko": "60014"
    },
    "meanResponseTime": {
        "total": "29630",
        "ok": "13591",
        "ko": "58226"
    },
    "standardDeviation": {
        "total": "24193",
        "ok": "12413",
        "ko": "8819"
    },
    "percentiles1": {
        "total": "22407",
        "ok": "10335",
        "ko": "60000"
    },
    "percentiles2": {
        "total": "60000",
        "ok": "22072",
        "ko": "60001"
    },
    "percentiles3": {
        "total": "60004",
        "ok": "36435",
        "ko": "60010"
    },
    "percentiles4": {
        "total": "60011",
        "ok": "43878",
        "ko": "60013"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 90,
    "percentage": 6
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 59,
    "percentage": 4
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 812,
    "percentage": 54
},
    "group4": {
    "name": "failed",
    "count": 539,
    "percentage": 36
},
    "meanNumberOfRequestsPerSecond": {
        "total": "17.857",
        "ok": "11.44",
        "ko": "6.417"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
