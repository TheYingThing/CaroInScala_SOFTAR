var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "2020",
        "ok": "1314",
        "ko": "706"
    },
    "minResponseTime": {
        "total": "72",
        "ok": "72",
        "ko": "10000"
    },
    "maxResponseTime": {
        "total": "60008",
        "ok": "59686",
        "ko": "60008"
    },
    "meanResponseTime": {
        "total": "20293",
        "ok": "10736",
        "ko": "38081"
    },
    "standardDeviation": {
        "total": "22380",
        "ok": "13705",
        "ko": "24434"
    },
    "percentiles1": {
        "total": "10162",
        "ok": "5387",
        "ko": "60000"
    },
    "percentiles2": {
        "total": "32168",
        "ok": "13324",
        "ko": "60000"
    },
    "percentiles3": {
        "total": "60001",
        "ok": "37061",
        "ko": "60004"
    },
    "percentiles4": {
        "total": "60006",
        "ok": "59095",
        "ko": "60007"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 194,
    "percentage": 10
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 51,
    "percentage": 3
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 1069,
    "percentage": 53
},
    "group4": {
    "name": "failed",
    "count": 706,
    "percentage": 35
},
    "meanNumberOfRequestsPerSecond": {
        "total": "13.649",
        "ok": "8.878",
        "ko": "4.77"
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
        "total": "1010",
        "ok": "458",
        "ko": "552"
    },
    "minResponseTime": {
        "total": "626",
        "ok": "626",
        "ko": "10018"
    },
    "maxResponseTime": {
        "total": "60008",
        "ok": "59686",
        "ko": "60008"
    },
    "meanResponseTime": {
        "total": "32492",
        "ok": "20575",
        "ko": "42380"
    },
    "standardDeviation": {
        "total": "23716",
        "ok": "17920",
        "ko": "23390"
    },
    "percentiles1": {
        "total": "29391",
        "ok": "12778",
        "ko": "60000"
    },
    "percentiles2": {
        "total": "60000",
        "ok": "32210",
        "ko": "60000"
    },
    "percentiles3": {
        "total": "60002",
        "ok": "58778",
        "ko": "60004"
    },
    "percentiles4": {
        "total": "60006",
        "ok": "59426",
        "ko": "60007"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 10,
    "percentage": 1
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 448,
    "percentage": 44
},
    "group4": {
    "name": "failed",
    "count": 552,
    "percentage": 55
},
    "meanNumberOfRequestsPerSecond": {
        "total": "6.824",
        "ok": "3.095",
        "ko": "3.73"
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
        "total": "1010",
        "ok": "856",
        "ko": "154"
    },
    "minResponseTime": {
        "total": "72",
        "ok": "72",
        "ko": "10000"
    },
    "maxResponseTime": {
        "total": "60008",
        "ok": "31443",
        "ko": "60008"
    },
    "meanResponseTime": {
        "total": "8095",
        "ok": "5472",
        "ko": "22675"
    },
    "standardDeviation": {
        "total": "11901",
        "ok": "6082",
        "ko": "21737"
    },
    "percentiles1": {
        "total": "4004",
        "ok": "3004",
        "ko": "10018"
    },
    "percentiles2": {
        "total": "10020",
        "ok": "9061",
        "ko": "47565"
    },
    "percentiles3": {
        "total": "31178",
        "ok": "15610",
        "ko": "60003"
    },
    "percentiles4": {
        "total": "60001",
        "ok": "31232",
        "ko": "60006"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 184,
    "percentage": 18
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 51,
    "percentage": 5
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 621,
    "percentage": 61
},
    "group4": {
    "name": "failed",
    "count": 154,
    "percentage": 15
},
    "meanNumberOfRequestsPerSecond": {
        "total": "6.824",
        "ok": "5.784",
        "ko": "1.041"
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
