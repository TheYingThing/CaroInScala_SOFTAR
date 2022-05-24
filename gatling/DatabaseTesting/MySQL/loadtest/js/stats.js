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
        "total": "887",
        "ok": "887",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "2997",
        "ok": "2997",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "2030",
        "ok": "2030",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "893",
        "ok": "893",
        "ko": "-"
    },
    "percentiles1": {
        "total": "2063",
        "ok": "2063",
        "ko": "-"
    },
    "percentiles2": {
        "total": "2930",
        "ok": "2930",
        "ko": "-"
    },
    "percentiles3": {
        "total": "2978",
        "ok": "2978",
        "ko": "-"
    },
    "percentiles4": {
        "total": "2993",
        "ok": "2993",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 5,
    "percentage": 25
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 15,
    "percentage": 75
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "1.176",
        "ok": "1.176",
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
        "total": "2818",
        "ok": "2818",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "2997",
        "ok": "2997",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "2916",
        "ok": "2916",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "58",
        "ok": "58",
        "ko": "-"
    },
    "percentiles1": {
        "total": "2931",
        "ok": "2931",
        "ko": "-"
    },
    "percentiles2": {
        "total": "2956",
        "ok": "2956",
        "ko": "-"
    },
    "percentiles3": {
        "total": "2988",
        "ok": "2988",
        "ko": "-"
    },
    "percentiles4": {
        "total": "2995",
        "ok": "2995",
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
        "total": "0.588",
        "ok": "0.588",
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
        "total": "887",
        "ok": "887",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "1308",
        "ok": "1308",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "1144",
        "ok": "1144",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "145",
        "ok": "145",
        "ko": "-"
    },
    "percentiles1": {
        "total": "1176",
        "ok": "1176",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1278",
        "ok": "1278",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1304",
        "ok": "1304",
        "ko": "-"
    },
    "percentiles4": {
        "total": "1307",
        "ok": "1307",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 5,
    "percentage": 50
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 5,
    "percentage": 50
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.588",
        "ok": "0.588",
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
