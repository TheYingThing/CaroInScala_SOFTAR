var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "20",
        "ok": "20",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "648",
        "ok": "648",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "2644",
        "ok": "2644",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "1636",
        "ok": "1636",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "928",
        "ok": "928",
        "ko": "-"
    },
    "percentiles1": {
        "total": "1601",
        "ok": "1601",
        "ko": "-"
    },
    "percentiles2": {
        "total": "2562",
        "ok": "2562",
        "ko": "-"
    },
    "percentiles3": {
        "total": "2618",
        "ok": "2618",
        "ko": "-"
    },
    "percentiles4": {
        "total": "2639",
        "ok": "2639",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 10,
    "percentage": 50
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 10,
    "percentage": 50
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "1.25",
        "ok": "1.25",
        "ko": "-"
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
        "total": "10",
        "ok": "10",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "2425",
        "ok": "2425",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "2644",
        "ok": "2644",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "2563",
        "ok": "2563",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "58",
        "ok": "58",
        "ko": "-"
    },
    "percentiles1": {
        "total": "2564",
        "ok": "2564",
        "ko": "-"
    },
    "percentiles2": {
        "total": "2602",
        "ok": "2602",
        "ko": "-"
    },
    "percentiles3": {
        "total": "2632",
        "ok": "2632",
        "ko": "-"
    },
    "percentiles4": {
        "total": "2642",
        "ok": "2642",
        "ko": "-"
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
    "count": 10,
    "percentage": 100
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.625",
        "ok": "0.625",
        "ko": "-"
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
        "total": "10",
        "ok": "10",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "648",
        "ok": "648",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "777",
        "ok": "777",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "709",
        "ok": "709",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "41",
        "ok": "41",
        "ko": "-"
    },
    "percentiles1": {
        "total": "706",
        "ok": "706",
        "ko": "-"
    },
    "percentiles2": {
        "total": "740",
        "ok": "740",
        "ko": "-"
    },
    "percentiles3": {
        "total": "772",
        "ok": "772",
        "ko": "-"
    },
    "percentiles4": {
        "total": "776",
        "ok": "776",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 10,
    "percentage": 100
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.625",
        "ok": "0.625",
        "ko": "-"
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
