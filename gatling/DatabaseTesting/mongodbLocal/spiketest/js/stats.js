var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "2020",
        "ok": "999",
        "ko": "1021"
    },
    "minResponseTime": {
        "total": "909",
        "ok": "909",
        "ko": "10000"
    },
    "maxResponseTime": {
        "total": "60005",
        "ok": "59850",
        "ko": "60005"
    },
    "meanResponseTime": {
        "total": "25777",
        "ok": "28742",
        "ko": "22876"
    },
    "standardDeviation": {
        "total": "19240",
        "ok": "16243",
        "ko": "21383"
    },
    "percentiles1": {
        "total": "14526",
        "ok": "26796",
        "ko": "10447"
    },
    "percentiles2": {
        "total": "42754",
        "ok": "42750",
        "ko": "54336"
    },
    "percentiles3": {
        "total": "60000",
        "ok": "57056",
        "ko": "60001"
    },
    "percentiles4": {
        "total": "60003",
        "ok": "59349",
        "ko": "60003"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 9,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 990,
    "percentage": 49
},
    "group4": {
    "name": "failed",
    "count": 1021,
    "percentage": 51
},
    "meanNumberOfRequestsPerSecond": {
        "total": "20.404",
        "ok": "10.091",
        "ko": "10.313"
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
        "ok": "319",
        "ko": "691"
    },
    "minResponseTime": {
        "total": "2134",
        "ok": "2134",
        "ko": "10038"
    },
    "maxResponseTime": {
        "total": "60004",
        "ok": "55688",
        "ko": "60004"
    },
    "meanResponseTime": {
        "total": "16962",
        "ok": "28061",
        "ko": "11837"
    },
    "standardDeviation": {
        "total": "13125",
        "ok": "14663",
        "ko": "8332"
    },
    "percentiles1": {
        "total": "10440",
        "ok": "29744",
        "ko": "10328"
    },
    "percentiles2": {
        "total": "18966",
        "ok": "41267",
        "ko": "10506"
    },
    "percentiles3": {
        "total": "45621",
        "ok": "47361",
        "ko": "10656"
    },
    "percentiles4": {
        "total": "60000",
        "ok": "49882",
        "ko": "60000"
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
    "count": 319,
    "percentage": 32
},
    "group4": {
    "name": "failed",
    "count": 691,
    "percentage": 68
},
    "meanNumberOfRequestsPerSecond": {
        "total": "10.202",
        "ok": "3.222",
        "ko": "6.98"
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
        "ok": "680",
        "ko": "330"
    },
    "minResponseTime": {
        "total": "909",
        "ok": "909",
        "ko": "10000"
    },
    "maxResponseTime": {
        "total": "60005",
        "ok": "59850",
        "ko": "60005"
    },
    "meanResponseTime": {
        "total": "34592",
        "ok": "29061",
        "ko": "45989"
    },
    "standardDeviation": {
        "total": "20314",
        "ok": "16924",
        "ko": "21907"
    },
    "percentiles1": {
        "total": "34508",
        "ok": "24567",
        "ko": "60000"
    },
    "percentiles2": {
        "total": "58869",
        "ok": "46490",
        "ko": "60001"
    },
    "percentiles3": {
        "total": "60001",
        "ok": "57978",
        "ko": "60003"
    },
    "percentiles4": {
        "total": "60003",
        "ok": "59581",
        "ko": "60004"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 9,
    "percentage": 1
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 671,
    "percentage": 66
},
    "group4": {
    "name": "failed",
    "count": 330,
    "percentage": 33
},
    "meanNumberOfRequestsPerSecond": {
        "total": "10.202",
        "ok": "6.869",
        "ko": "3.333"
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
