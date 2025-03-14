SUMMARY = "This is a simple example recipe that cross-compiles a Go program."
SECTION = "examples"
HOMEPAGE = "https://golang.org/"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://go.googlesource.com/example;branch=master;protocol=https;destsuffix=${GO_SRCURI_DESTSUFFIX}"
SRCREV = "d7b0ac1278591aea848a99258ccfdee8e4d454c1"
UPSTREAM_CHECK_COMMITS = "1"

GO_IMPORT = "golang.org/x/example"
GO_INSTALL = "${GO_IMPORT}/hello"

export GO111MODULE = "off"

inherit go

# This is just to make clear where this example is
do_install:append() {
    mv ${D}${bindir}/hello ${D}${bindir}/${BPN}
}

# /usr/lib/go/src/golang.org/x/example/ragserver/tests/weaviate-show-all.sh is requiring bash
RDEPENDS:${PN}-dev += "bash"
