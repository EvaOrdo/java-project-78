.DEFAULT_GOAL := build-run

clean:
	make -C app clean

build:
	make -C app build

install:
	make -C app install

test:
	make -C app test

report:
	make -C app report

.PHONY: build