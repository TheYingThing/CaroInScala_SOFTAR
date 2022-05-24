var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "1822",
        "ok": "1822",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "71",
        "ok": "71",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "7481",
        "ok": "7481",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "889",
        "ok": "889",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "1218",
        "ok": "1218",
        "ko": "-"
    },
    "percentiles1": {
        "total": "479",
        "ok": "479",
        "ko": "-"
    },
    "percentiles2": {
        "total": "933",
        "ok": "933",
        "ko": "-"
    },
    "percentiles3": {
        "total": "3365",
        "ok": "3365",
        "ko": "-"
    },
    "percentiles4": {
        "total": "6814",
        "ok": "6814",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 1286,
    "percentage": 71
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 202,
    "percentage": 11
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 334,
    "percentage": 18
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "13.699",
        "ok": "13.699",
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
        "total": "911",
        "ok": "911",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "145",
        "ok": "145",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "7481",
        "ok": "7481",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "1335",
        "ok": "1335",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "1559",
        "ok": "1559",
        "ko": "-"
    },
    "percentiles1": {
        "total": "700",
        "ok": "700",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1595",
        "ok": "1595",
        "ko": "-"
    },
    "percentiles3": {
        "total": "4931",
        "ok": "4931",
        "ko": "-"
    },
    "percentiles4": {
        "total": "7230",
        "ok": "7230",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 497,
    "percentage": 55
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 129,
    "percentage": 14
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 285,
    "percentage": 31
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "6.85",
        "ok": "6.85",
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
        "total": "911",
        "ok": "911",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "71",
        "ok": "71",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "2220",
        "ok": "2220",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "442",
        "ok": "442",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "374",
        "ok": "374",
        "ko": "-"
    },
    "percentiles1": {
        "total": "348",
        "ok": "348",
        "ko": "-"
    },
    "percentiles2": {
        "total": "574",
        "ok": "574",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1247",
        "ok": "1247",
        "ko": "-"
    },
    "percentiles4": {
        "total": "1743",
        "ok": "1743",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 789,
    "percentage": 87
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 73,
    "percentage": 8
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 49,
    "percentage": 5
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "6.85",
        "ok": "6.85",
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
