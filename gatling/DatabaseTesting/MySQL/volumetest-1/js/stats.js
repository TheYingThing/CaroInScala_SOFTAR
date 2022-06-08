var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "3000",
        "ok": "1154",
        "ko": "1846"
    },
    "minResponseTime": {
        "total": "92",
        "ok": "92",
        "ko": "10000"
    },
    "maxResponseTime": {
        "total": "60008",
        "ok": "54517",
        "ko": "60008"
    },
    "meanResponseTime": {
        "total": "14137",
        "ok": "14082",
        "ko": "14172"
    },
    "standardDeviation": {
        "total": "13380",
        "ok": "13984",
        "ko": "12988"
    },
    "percentiles1": {
        "total": "10523",
        "ok": "8752",
        "ko": "10563"
    },
    "percentiles2": {
        "total": "11088",
        "ok": "25677",
        "ko": "10886"
    },
    "percentiles3": {
        "total": "50828",
        "ok": "48488",
        "ko": "60000"
    },
    "percentiles4": {
        "total": "60000",
        "ok": "50960",
        "ko": "60001"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 85,
    "percentage": 3
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 73,
    "percentage": 2
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 996,
    "percentage": 33
},
    "group4": {
    "name": "failed",
    "count": 1846,
    "percentage": 62
},
    "meanNumberOfRequestsPerSecond": {
        "total": "22.388",
        "ok": "8.612",
        "ko": "13.776"
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
        "ok": "331",
        "ko": "1169"
    },
    "minResponseTime": {
        "total": "1439",
        "ok": "1439",
        "ko": "10159"
    },
    "maxResponseTime": {
        "total": "60006",
        "ok": "54517",
        "ko": "60006"
    },
    "meanResponseTime": {
        "total": "15876",
        "ok": "14776",
        "ko": "16187"
    },
    "standardDeviation": {
        "total": "14557",
        "ok": "10846",
        "ko": "15432"
    },
    "percentiles1": {
        "total": "10818",
        "ok": "10385",
        "ko": "10821"
    },
    "percentiles2": {
        "total": "11074",
        "ok": "27218",
        "ko": "11006"
    },
    "percentiles3": {
        "total": "60000",
        "ok": "31694",
        "ko": "60000"
    },
    "percentiles4": {
        "total": "60001",
        "ok": "36525",
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
    "count": 331,
    "percentage": 22
},
    "group4": {
    "name": "failed",
    "count": 1169,
    "percentage": 78
},
    "meanNumberOfRequestsPerSecond": {
        "total": "11.194",
        "ok": "2.47",
        "ko": "8.724"
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
        "ok": "823",
        "ko": "677"
    },
    "minResponseTime": {
        "total": "92",
        "ok": "92",
        "ko": "10000"
    },
    "maxResponseTime": {
        "total": "60008",
        "ok": "51886",
        "ko": "60008"
    },
    "meanResponseTime": {
        "total": "12399",
        "ok": "13803",
        "ko": "10692"
    },
    "standardDeviation": {
        "total": "11837",
        "ok": "15055",
        "ko": "5440"
    },
    "percentiles1": {
        "total": "10003",
        "ok": "6362",
        "ko": "10004"
    },
    "percentiles2": {
        "total": "11617",
        "ok": "25217",
        "ko": "10011"
    },
    "percentiles3": {
        "total": "47734",
        "ok": "49481",
        "ko": "10022"
    },
    "percentiles4": {
        "total": "51075",
        "ok": "51019",
        "ko": "60000"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 85,
    "percentage": 6
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 73,
    "percentage": 5
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 665,
    "percentage": 44
},
    "group4": {
    "name": "failed",
    "count": 677,
    "percentage": 45
},
    "meanNumberOfRequestsPerSecond": {
        "total": "11.194",
        "ok": "6.142",
        "ko": "5.052"
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
