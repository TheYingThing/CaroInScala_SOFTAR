var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "8620",
        "ok": "3614",
        "ko": "5006"
    },
    "minResponseTime": {
        "total": "76",
        "ok": "76",
        "ko": "9782"
    },
    "maxResponseTime": {
        "total": "60026",
        "ok": "58680",
        "ko": "60026"
    },
    "meanResponseTime": {
        "total": "17881",
        "ok": "10797",
        "ko": "22994"
    },
    "standardDeviation": {
        "total": "19098",
        "ok": "11452",
        "ko": "21702"
    },
    "percentiles1": {
        "total": "10028",
        "ok": "6251",
        "ko": "10062"
    },
    "percentiles2": {
        "total": "16964",
        "ok": "16031",
        "ko": "60000"
    },
    "percentiles3": {
        "total": "60000",
        "ok": "35609",
        "ko": "60001"
    },
    "percentiles4": {
        "total": "60006",
        "ok": "50004",
        "ko": "60011"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 216,
    "percentage": 3
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 203,
    "percentage": 2
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 3195,
    "percentage": 37
},
    "group4": {
    "name": "failed",
    "count": 5006,
    "percentage": 58
},
    "meanNumberOfRequestsPerSecond": {
        "total": "16.388",
        "ok": "6.871",
        "ko": "9.517"
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
        "total": "4310",
        "ok": "1375",
        "ko": "2935"
    },
    "minResponseTime": {
        "total": "196",
        "ok": "196",
        "ko": "10000"
    },
    "maxResponseTime": {
        "total": "60015",
        "ok": "58680",
        "ko": "60015"
    },
    "meanResponseTime": {
        "total": "17150",
        "ok": "13590",
        "ko": "18818"
    },
    "standardDeviation": {
        "total": "16845",
        "ok": "10746",
        "ko": "18812"
    },
    "percentiles1": {
        "total": "10112",
        "ok": "11914",
        "ko": "10084"
    },
    "percentiles2": {
        "total": "13443",
        "ok": "18620",
        "ko": "10235"
    },
    "percentiles3": {
        "total": "60000",
        "ok": "38632",
        "ko": "60000"
    },
    "percentiles4": {
        "total": "60005",
        "ok": "48546",
        "ko": "60006"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 80,
    "percentage": 2
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 15,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 1280,
    "percentage": 30
},
    "group4": {
    "name": "failed",
    "count": 2935,
    "percentage": 68
},
    "meanNumberOfRequestsPerSecond": {
        "total": "8.194",
        "ok": "2.614",
        "ko": "5.58"
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
        "total": "4310",
        "ok": "2239",
        "ko": "2071"
    },
    "minResponseTime": {
        "total": "76",
        "ok": "76",
        "ko": "9346"
    },
    "maxResponseTime": {
        "total": "60026",
        "ok": "57145",
        "ko": "60026"
    },
    "meanResponseTime": {
        "total": "18611",
        "ok": "9082",
        "ko": "28913"
    },
    "standardDeviation": {
        "total": "21086",
        "ok": "11535",
        "ko": "24023"
    },
    "percentiles1": {
        "total": "10001",
        "ok": "2894",
        "ko": "10006"
    },
    "percentiles2": {
        "total": "21918",
        "ok": "14918",
        "ko": "60000"
    },
    "percentiles3": {
        "total": "60001",
        "ok": "35003",
        "ko": "60002"
    },
    "percentiles4": {
        "total": "60011",
        "ok": "50123",
        "ko": "60017"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 136,
    "percentage": 3
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 188,
    "percentage": 4
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 1915,
    "percentage": 44
},
    "group4": {
    "name": "failed",
    "count": 2071,
    "percentage": 48
},
    "meanNumberOfRequestsPerSecond": {
        "total": "8.194",
        "ok": "4.257",
        "ko": "3.937"
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
